/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package gui;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JFrame;

/**
 * <p>The <b>MAIN</b>-GUI class.</p>
 * <p>This dynamic superclass is meant for easy use or easy extending.</p>
 * 
 * @param T     The type of the main-class subclass
 * @param P     The type of the main-panel subclass
 * @see         MainPanel
 * @see         WinAdapter -for creating objects.
 * @author rash4
 */
public abstract class WinGUI<T extends WinGUI<T, P>, P extends MainPanel<P>> 
        implements funx.Chainable<T>{
    public void basicSetup(){
        final var title = this.frame.getTitle();
        if(title.isEmpty() || title.contains("Null")) this.frame.setTitle("Basic");
        this.panel.setLayout(null);
        final var size = this.panel.getPreferredSize();
        if(size == null || size.width < 99 || size.height < 99)
            this.panel.setPreferredSize(new Dimension(460, 420));
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(true);
        this.frame.setDefaultCloseOperation(2);
        this.frame.setVisible(true);
    }
    public void setPainter(graphicker.Painter repaint){
        if(repaint == null || this.panel == null) return;
        this.panel.paints = repaint;
        this.panel.repaint(); // safe call.
    }
    public void setInputs(Inputs inputs){
        if(inputs == null || this.panel == null)return;
        this    .setKeys(inputs)
                .setMouseListener(inputs)
                .setMouseMotion(inputs)
                .setMouseWheel(inputs);
    }
    public final T setMouse(MouseAdapter ma){
        if(ma == null || this.panel == null)return this.self();
        this.setMouseListener(ma);
        this.setMouseMotion(ma);
        this.setMouseWheel(ma);
        return this.self();
    }
    protected final T setMouseListener(MouseListener mouse){
        final var mals = this.panel.getMouseListeners();
        if(mals.length > 0)for(var mal : mals){
            this.panel.removeMouseListener(mal);
        }
        this.panel.addMouseListener(mouse);
        return this.self();
    }
    protected final T setMouseMotion(MouseMotionListener motion){
        final var mams = this.panel.getMouseMotionListeners();
        if(mams.length > 0)for(var mam : mams){
            this.panel.removeMouseMotionListener(mam);
        }
        this.panel.addMouseMotionListener(motion);
        return this.self();
    }
    protected final T setMouseWheel(MouseWheelListener wheel){
        final var maws = this.panel.getMouseWheelListeners();
        if(maws.length > 0)for(var maw : maws){
            this.panel.removeMouseWheelListener(maw);
        }
        this.panel.addMouseWheelListener(wheel);
        return this.self();
    }
    public final T setKeys(KeyListener keys){
        if(keys == null || this.panel == null)return this.self();
        final var kels = this.panel.getKeyListeners();
        if(kels.length > 0)for(var kel : kels){
            this.panel.removeKeyListener(kel);
        }
        this.panel.addKeyListener(keys);
        return this.self();
    }
    public void setReiszing(Resizer ress){
        if(ress == null || this.panel == null)return;
        final var res = this.panel.getComponentListeners();
        if(res.length > 0)for(var cml : res){
            this.panel.removeComponentListener(cml);
        }
        this.panel.addComponentListener(new ComponentAdapter(){
            @Override public void componentResized(ComponentEvent evt){
                ress.resize(WinGUI.this.panel.getSize());
            }
        });
    }
    public T setFocusOnPanel(){
        if(/*this.panel == null || */this.frame == null) return this.self();
        final var focs = this.frame.getWindowFocusListeners();
        if(focs.length > 0) for(var fcs : focs){
            this.frame.removeWindowFocusListener(fcs);
        }
        this.frame.addWindowFocusListener(new WindowFocusListener(){
            @Override public void windowGainedFocus(WindowEvent e) {
                WinGUI.this.panel.requestFocusInWindow();
            }
            @Override public void windowLostFocus(WindowEvent e){}
        });
        return this.self();
    }
    /**Calls the main-panel's {@code repaint()} method.*/
    public void repaint(){this.panel.repaint();}
    @Override public T self() {
        return (T)this;
    }
    protected MainPanel<P> panel;
    protected JFrame frame;
}