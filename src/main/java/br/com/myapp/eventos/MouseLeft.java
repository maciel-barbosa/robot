// 
// Decompiled by Procyon a0.5.36
// 

package br.com.myapp.eventos;

import java.awt.Robot;


public class MouseLeft implements Polimorfo
{
    @Override
    public void executa() {
        Robot robot = null;
        try {
            robot = new Robot();
        }
        catch (Exception failed) {
            System.err.println("Inst\u00e2ncia do Robot falhou: " + failed);
        }
        
        robot.mousePress(4096);
        robot.mouseRelease(4096);

    }
    
    @Override
    public String toString() {
        return "Mouse Esquerdo";
    }
}
