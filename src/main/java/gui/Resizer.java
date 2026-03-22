/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gui;

/**
 * <p>Resize component based on the container's size changes.</p>
 * @author rash4
 */
@FunctionalInterface
public interface Resizer {
    void resize(java.awt.Dimension containerSize);
}