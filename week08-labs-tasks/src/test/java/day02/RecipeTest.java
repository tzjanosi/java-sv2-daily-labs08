package day02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {
    @Test
    void testConstructorWithName() {
        Recipe receipe=new Recipe("Pite");
        assertEquals("Pite", receipe.getName());
    }
    @Test
    void testConstructorWithNameAndDescription() {
        Recipe receipe=new Recipe("Rántotta","Feltörjük, beleöntjük, összekeverjük!");
        assertEquals("Rántotta", receipe.getName());
        assertEquals("Feltörjük, beleöntjük, összekeverjük!", receipe.getDescription());
    }
    @Test
    void testIngredients() {
        Recipe receipe=new Recipe("Pizza");
        receipe.addIngredient("liszt");
        assertEquals(1, receipe.getIngredients().size());
        assertEquals("liszt", receipe.getIngredients().get(0));
        receipe.addIngredient("cukor","paradicsomszósz","olivabogyó","tonhal","hagyma");
        assertEquals(6, receipe.getIngredients().size());
        assertEquals("hagyma", receipe.getIngredients().get(5));

    }

}