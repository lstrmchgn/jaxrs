package com.leirra.sample.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
@Produces("text/shortdate")
public class ShortDateMessageBodyWriter implements MessageBodyWriter<Date>{

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return Date.class.isAssignableFrom(type);
	}

	@Override
	public long getSize(Date t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public void writeTo(Date date, Class<?> type, 
			Type type1, 
			Annotation[] annotations, 
			MediaType mediaType,
			MultivaluedMap<String, Object> mm, 
			OutputStream out) throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
		String shortdate = date.getDate()+"-"+date.getMonth()+"-"+date.getYear();
		out.write(shortdate.getBytes());
//		out.write(date.toString().getBytes());
	}
	
}
