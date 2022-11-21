package com.kodlama.io.northwind.core.utilities.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service  // arka planda neseneyi newler. Projeyi run yaptığında bütün anotasyonları tarar.Bütün anostasyonları newler bir IOC içine koyar. Yarın biri isterse veririm.
          // Constructarlarda isteyecem bana referansları verirsin.
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{
	
	// Product içinde Category varsa bana categoryId lazımsa  mapper,category.id'ye bakar.

	private ModelMapper modelMapper;

	@Override
	public ModelMapper forResponse() {
	
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)        //belirsizlik görürsen ignore et (product içinde hem Category hem de categoryId varsa)
		.setMatchingStrategy(MatchingStrategies.LOOSE); //LOOSE gevşek 
		return this.modelMapper;
	}

	@Override
	public ModelMapper forRequest() {
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)        //belirsizlik görürsen ignore et (product içinde hem Category hem de categoryId varsa)
		.setMatchingStrategy(MatchingStrategies.STANDARD);
		return this.modelMapper;
	}
}
