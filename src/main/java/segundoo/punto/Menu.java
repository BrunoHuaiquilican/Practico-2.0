package segundoo.punto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Menu {

    private List<Plato> platos ;

    public Menu(List<Plato> platos) {
        if (platos == null || platos.isEmpty()) {
            throw new IllegalArgumentException("El menú debe tener al menos un plato.");
        }
        this.platos = new ArrayList<>(platos);
    }

    public List<Plato> obteberPlatos() {
        return Collections.unmodifiableList(platos);
    }
}
