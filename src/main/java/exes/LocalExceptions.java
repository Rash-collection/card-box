/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package exes;

/**
 * <p>This project's locally prepared exceptions.</p>
 * <p>This {@link RuntimeException} type is made as superclass for exception's log.</p>
 * @author rash4
 */
public abstract class LocalExceptions extends RuntimeException{
    public LocalExceptions(){
        super();
    }
    public LocalExceptions(String msg){
        super(msg);
    }
}