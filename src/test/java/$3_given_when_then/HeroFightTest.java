package $3_given_when_then;

import hero.Hero;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeroFightTest {
	private int MIN_DAMAGE = 6;

	@Test
	public void newHeroShouldHaveZeroFightsWon() {
		Hero hero = new Hero();
		assertThat(hero.numberOfFightsWon).isEqualTo(0);
	}

	@Test
	public void heroWithGreaterPowerShouldWin() {
		Hero superman = new Hero().power(5);
		Hero lexLuthor = new Hero().power(4);

		boolean supermanWon = superman.fight(lexLuthor);

		assertThat(supermanWon).isTrue();
	}

	@Test
	public void heroShouldRememberNumberOfWonFight() {
		Hero superman = new Hero().power(5);
		Hero lexLuthor = new Hero().power(4);

		superman.fight(lexLuthor);

		assertThat(superman.numberOfFightsWon).isEqualTo(1);
		assertThat(lexLuthor.numberOfFightsWon).isEqualTo(0);
	}

	@Test
	public void heroWhoWasDamagedHasLowerHealth() {
		Hero lexLuthor = new Hero().health(10);

		lexLuthor.inflictDamage(MIN_DAMAGE);

		assertThat(lexLuthor.getHealth()).isEqualTo(9);
	}
}
