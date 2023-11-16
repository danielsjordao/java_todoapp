/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ASUS
 */
public class ButtonColumnCellRenderer extends DefaultTableCellRenderer{
   
    private String buttonType;
    
    public ButtonColumnCellRenderer(String buttonType){
        this.buttonType = buttonType;
    };

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }
    
    
}
