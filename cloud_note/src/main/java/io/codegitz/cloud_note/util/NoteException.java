package io.codegitz.cloud_note.util;

public class NoteException extends Exception{
      public NoteException(){}
      public NoteException(String str,Exception e){
    	  super(str);
      }
}
