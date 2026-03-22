/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gui;

import graphicker.Painter;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author rash4
 */
public abstract class MainPanel<T extends MainPanel<T>> extends JPanel
        implements funx.Chainable<T>{
    protected MainPanel(){
        this.paints = grr->{
            throw new UnsupportedOperationException();
        };
    }
    protected MainPanel(Dimension preferredSize){
        this();
        super.setPreferredSize(preferredSize);
    }
    protected MainPanel(graphicker.Painter paints){
        this.paints = paints;
    }
    @Override protected void paintComponent(java.awt.Graphics g){
        super.paintComponent(g);
        this.paints.paint((java.awt.Graphics2D)g);
    }
    public void setPainter(Painter paint){
        this.paints = paint;
    }
    @Override public T self() {
        return (T)this;
    }
    protected Painter paints;
}