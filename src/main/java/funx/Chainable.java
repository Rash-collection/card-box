/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package funx;

/**
 * <p>Abstract self-casting method for dynamic types, especially for chaining.</p>
 * @param T     the return type of {@link #self()} for self referencing.
 * @author rash4
 */
public interface Chainable<T> {
    /**
     * <p>Easy self cast method.</p>
     * @return  {@code this} caste to the {@code <T>} type.
     */
    T self();
}