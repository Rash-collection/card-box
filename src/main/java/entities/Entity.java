/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entities;

import funx.Chainable;

/**
 * <p>The superclass of all entity related objects or items.</p>
 * @param T     The cast type of the subclass
 * @see         funx.Chainable
 * @author rash4
 */
public abstract class Entity<T extends Entity<T>> implements Chainable<T>,
        Comparable<T>{
    protected Entity(String codeName){
        this.CODE_NAME = codeName;
    }
    protected final String CODE_NAME;
}