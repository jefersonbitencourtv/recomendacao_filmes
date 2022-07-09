package api.desafio.recomendacao_filmes.domain.enums;

import java.util.Arrays;

public enum MovieGenre {
    ACTION("18", 41, Integer.MAX_VALUE),
    ANIMATION("16", 21,35),
    COMEDY("35", 36, 40),
    DOCUMENTARY("99", 0, 20),
    //Values negative need to be inverted, max is the value closest to 0
    THRILLER("53", Integer.MIN_VALUE, -1);

    private final String id;
    private final int min;
    private final int max;

    private MovieGenre(String id, Integer min, Integer max) {
        this.id = id;
        this.min = min;
        this.max = max;
    }

    public String getId() {
        return this.id;
    }

    public static MovieGenre get(int tempPresent) {
        return Arrays.stream(values())
                .filter(myEnum -> tempPresent >= myEnum.min  && tempPresent <= myEnum.max)
                .findFirst()
                .orElse(null);
    }
}
