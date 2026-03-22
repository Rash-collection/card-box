/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gui;

import java.awt.Dimension;

/**
 *
 * @author rash4
 */
//class WinAdapter{
public class WinAdapter <T extends WinAdapter<T, P>, P extends MainPanel<P>> 
        extends WinGUI<T, P>{
    public WinAdapter(){
        this("Null", null);
    }
    public WinAdapter(String title){
        this(title, null);
    }
    public WinAdapter(Dimension preferredSize){
        this("Null", preferredSize);
    }
    public WinAdapter(String title, Dimension preferredSize){
        this.panel = new PanelAdapter(preferredSize);
        this.frame = new javax.swing.JFrame(title);
        this.frame.setContentPane(this.panel);
    }
    protected class PanelAdapter<T extends P> extends MainPanel<PanelAdapter<T>>{
        protected PanelAdapter(){super(new Dimension(260, 220));}
        protected PanelAdapter(Dimension preferredSize){
            super(preferredSize);
            super.paints = (grr->{
                final var siz = PanelAdapter.super.getSize();
                grr.setColor(java.awt.Color.BLACK);
                grr.fillRoundRect(10, 10, siz.width-20, siz.height-20, 40, 40);
            });
        }
    }
    public void thisGAGA(){
        super.basicSetup();
    }
}