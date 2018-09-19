package com.paypal.book;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
public class BookInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 @Override
 protected Class < ? > [] getRootConfigClasses() {
  return new Class[] {
   BookConfiguration.class
  };
 }
 @Override
 protected Class < ? > [] getServletConfigClasses() {
  return null;
 }
 @Override
 protected String[] getServletMappings() {
  return new String[] {
   "/rest/*"
  };
 }
}