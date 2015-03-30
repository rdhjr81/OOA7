/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rebates;

import coupons.*;
import secondaryHeaders.*;
import rebates.*;

/**
 *
 * @author Robert
 */
public interface Applicable {
    public boolean applies(String[] s);
}
