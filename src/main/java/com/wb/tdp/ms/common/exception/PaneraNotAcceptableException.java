package com.wb.tdp.ms.common.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaneraNotAcceptableException extends RuntimeException {
       
       
       /**
       * 
        */
       private static final long serialVersionUID = 5501709449809304793L;
       /**
       * Args for message text place holder
       */
       private Object[] args;
       
       /**
       * Construct an Exception with message.
       * @param errorCode
       * @param message
       * @param args
       */
       public PaneraNotAcceptableException(String message, Object[] args) {
             super(message);
             this.args = args;
       }

}
