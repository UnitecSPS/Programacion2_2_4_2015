/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author Aula
 */
public interface Commentable {
    public void addComment(String body,  String autor, int idpost);
    public void deleteComment(int id);
}
