package io.chibana.mock.transaction_api.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.time.Instant;

@Data
public class TransactionRequestDTO {

    private Integer userId;
    private Timestamp createdDate;

    public TransactionRequestDTO(Integer userId, Integer year, Integer month) {
        this.userId = userId;
        this.createdDate = createTimestampByMonthAndYear(year, month);
    }

    private Timestamp createTimestampByMonthAndYear(Integer year, Integer month) {
        final String monthFormatted = month < 10 ? "0" + month.toString() : month.toString();
        final String date = String.format("%s-%s-01T00:00:00Z", year.toString(), monthFormatted);
        final Instant instantParsed = Instant.parse(date);
        return Timestamp.from(instantParsed);
    }

}
