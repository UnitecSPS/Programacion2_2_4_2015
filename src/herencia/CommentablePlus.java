/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.io.Serializable;

/**
 *
 * @author Aula
 */
public interface CommentablePlus extends Commentable, Serializable, Cloneable
{
    boolean printComment(int id);
}
