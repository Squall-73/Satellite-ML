package pruebas.satelites.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalHandlerException {


		@ExceptionHandler(NotEnoughInformationException.class)
		public ResponseEntity<?> notEnoughInformationException(Exception e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}


}
