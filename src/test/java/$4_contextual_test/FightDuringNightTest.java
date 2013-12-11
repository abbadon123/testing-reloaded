package $4_contextual_test;

import static com.google.common.collect.Maps.newHashMap;
import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.Test;

import hero.Hero;
import org.junit.Before;

public class FightDuringNightTest {

	private Map<String, String> fightContext = newHashMap();

	@Before
	public void setUpNightContext() {
		fightContext.put("timeOfDay", "night");
	}

    @Test
    public void superman_loses_during_night_with_equal_power() {
        Hero superman = new Hero().alias("Superman").power(3);
        Hero lexLuthor = new Hero().realLastName("Lex").realLastName("Luthor").power(3);

        boolean supermanWon = superman.fight(lexLuthor, fightContext);

        assertThat(supermanWon).isFalse();
    }
}
