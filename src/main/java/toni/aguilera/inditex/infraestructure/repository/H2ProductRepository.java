package toni.aguilera.inditex.infraestructure.repository;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import toni.aguilera.inditex.domain.Product;
import toni.aguilera.inditex.domain.ProductId;
import toni.aguilera.inditex.domain.ProductQuery;
import toni.aguilera.inditex.domain.ProductRepository;
import toni.aguilera.inditex.domain.exception.ProductNotFoundException;

import java.time.LocalDateTime;
import java.util.Map;

@Repository
public class H2ProductRepository implements ProductRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public H2ProductRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Product find(ProductQuery query) {
        String sql = """
                SELECT * FROM PRICES
                WHERE START_DATE <= :date
                  AND END_DATE >= :date
                  AND PRODUCT_ID = :productId
                  AND BRAND_ID = :brand
                ORDER BY PRIORITY DESC
                LIMIT 1
                """;
        Map<String, Object> parameters = Map.of("productId", query.productId().id(),
                "brand", query.brand().id(),
                "date", query.time().getValue());
        try {
            return jdbcTemplate.queryForObject(sql, parameters, mapResultSetToProduct());
        } catch (EmptyResultDataAccessException ex) {
            throw new ProductNotFoundException();
        }
    }

    private RowMapper<Product> mapResultSetToProduct() {
        return (rs, rowNum) -> {
            ProductId productId = new ProductId(rs.getInt("product_id"));
            LocalDateTime startDate = rs.getObject("start_date", LocalDateTime.class);
            LocalDateTime endDate = rs.getObject("end_date", LocalDateTime.class);
            Integer priceList = rs.getInt("price_list");
            Double price = rs.getDouble("price");
            return new Product(productId, startDate, endDate, priceList, price);
        };
    }
}
