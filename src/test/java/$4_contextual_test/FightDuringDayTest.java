package $4_contextual_test;

import hero.Hero;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.collect.Maps.newHashMap;
import static org.assertj.core.api.Assertions.*;

public class FightDuringDayTest {

	private Map<String, String> fightContext;

	@Before
	public void setUpDayContext() {
		fightContext = newHashMap();
		fightContext.put("timeOfDay", "day");
	}

    @Test
    public void superman_wins_during_day_with_equal_power() {
        Hero superman = new Hero().power(3);
        Hero lexLuthor = new Hero().power(3);

        boolean supermanWon = superman.fight(lexLuthor, fightContext);

        assertThat(supermanWon).isTrue();
    }

    @Test
    public void superman_loses_during_day_with_equal_power_against_kryptonite() {
        Hero superman = new Hero().alias("Superman").power(3);
        Hero lexLuthor = new Hero().power(3).weapon("kryptonite");

        boolean supermanWon = superman.fight(lexLuthor, fightContext);

        assertThat(supermanWon).isFalse();
    }
}
