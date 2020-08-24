package io.chibana.mock.transaction_api.dto.mapper;

import io.chibana.mock.transaction_api.dto.TransactionRequestDTO;
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

    Locale LOCALE_BRAZIL = new Locale("pt", "BR");

    @Mapping(target = "value", source = "value", qualifiedByName = "moneyConversion")
    TransactionResponseDTO modelToResponseDTO(Transaction transaction);

    default Transaction requestDTOToModel(TransactionRequestDTO requestDTO){
        return new Transaction(requestDTO.getUserId(), requestDTO.getCreatedDate());
    }

    @Named("moneyConversion")
    default String moneyConversion(BigInteger value) {
        double result = value.intValue() / 100.00;
        return NumberFormat.getCurrencyInstance(LOCALE_BRAZIL).format(result);
    }

}
