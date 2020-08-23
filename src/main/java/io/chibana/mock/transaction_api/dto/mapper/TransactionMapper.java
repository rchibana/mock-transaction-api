package io.chibana.mock.transaction_api.dto.mapper;

import io.chibana.mock.transaction_api.dto.TransactionResponseDTO;
import io.chibana.mock.transaction_api.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Locale;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(target = "value", source = "value", qualifiedByName = "moneyConversion")
    TransactionResponseDTO transactionToResponseDTO(Transaction transaction);

    @Named("moneyConversion")
    default String moneyConversion(BigInteger value) {
        final Locale localeBrazil = new Locale("pt", "BR");
        float result = (float) (value.floatValue() / 100.00);

        return NumberFormat.getCurrencyInstance(localeBrazil).format(result);
    }

}
