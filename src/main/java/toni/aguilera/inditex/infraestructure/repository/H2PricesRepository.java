package toni.aguilera.inditex.infraestructure.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import toni.aguilera.inditex.domain.PricesRepository;
import toni.aguilera.inditex.domain.Product;
import toni.aguilera.inditex.domain.ProductId;
import toni.aguilera.inditex.domain.ProductQuery;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Repository
public class H2PricesRepository implements PricesRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;


    public H2PricesRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> find(ProductQuery query) {
        String sql = """
                SELECT * FROM PRICES
                WHERE START_DATE <= :date AND END_DATE >= :date
                AND PRODUCT_ID = :productId AND BRAND_ID = :brand
                """;
        Map<String, Object> parameters = Map.of("productId", query.getProductId().getId(),
                "brand", query.getBrand().getId(),
                "date", query.getTime().getValue());
        return jdbcTemplate.query(sql, parameters, mapResultSetToProduct());
    }

    private RowMapper<Product> mapResultSetToProduct() {
        return (rs, rowNum) -> {
            ProductId productId = new ProductId(rs.getInt("product_id"));
            Timestamp startDate = rs.getObject("start_date", Timestamp.class);
            Timestamp endDate = rs.getObject("end_date", Timestamp.class);
            Integer priceList = rs.getInt("price_list");
            Double price = rs.getDouble("price");
            return new Product(productId, startDate, endDate, priceList, price);
        };
    }
}
