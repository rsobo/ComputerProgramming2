import java.io.Serializable;
import java.util.UUID;

public class Pokemon implements Serializable {
    private UUID pokemonId;
    private String pokemonType;
    private String name;
    private boolean checkedIn = false;

    public Pokemon(String pokemonType, String name) {
        pokemonId = UUID.randomUUID();
        this.pokemonType = pokemonType;
        this.name = name;
    }

    public UUID getPokemonId() {
        return pokemonId;
    }

    public String getPokemonType() {
        return pokemonType;
    }

    public String getName() {
        return name;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void checkIn() {
        checkedIn = true;
    }

    public void checkOut() {
        checkedIn = false;
    }
}
