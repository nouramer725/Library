/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author Dell
 */

public class Poet extends author {

    protected Poet(String name, String gender, String email) {
        super(name, gender, email);
    }

   public String write() {
    StringBuilder result = new StringBuilder();

    result.append("William Shakespeare:\n");
    result.append("Notable Works: Sonnets, plays like Romeo and Juliet, Hamlet, and Macbeth\n\n");

    result.append("Emily Dickinson:\n");
    result.append("Notable Works: Poems such as Because I could not stop for Death, Hope is the thing with feathers, and I'm Nobody! Who are you?\n\n");

    result.append("Langston Hughes:\n");
    result.append("Notable Works: Poems like Harlem (Dream Deferred), The Negro Speaks of Rivers, and I, Too\n\n");

    result.append("Maya Angelou:\n");
    result.append("Notable Works: Autobiographical poem Still I Rise, Phenomenal Woman, and Caged Bird\n\n");

    result.append("Robert Frost:\n");
    result.append("Notable Works: Poems such as The Road Not Taken, Stopping by Woods on a Snowy Evening, and Fire and Ice\n\n");

    result.append("Pablo Neruda:\n");
    result.append("Notable Works: Twenty Love Poems and a Song of Despair, Odes to Common Things, and The Captain's Verses\n\n");

    return result.toString();
}

    @Override
    protected void booksNumber(int n) { 
        boo= new book[n]; 
    }
}
    

