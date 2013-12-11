package $8_assertions;

import static org.assertj.core.api.Assertions.*;
import hero.Hero;
import hero.HeroOrigin;
import hero.HeroService;

import org.junit.Test;

import static $8_assertions.StructureTest.AssertHero.assertThatHero;

public class StructureTest {

	private HeroService heroService = new HeroService();

	@Test
	public void hero_has_complete_structure() {
		Hero hero = heroService.getHero(1);

		assertThatHero(hero)
				.hasAlias("Superman")
				.isCalled("Clark", "Kent")
				.comesFrom(new HeroOrigin(87, "Krypton"))
				.hasSymbols("blue costume", "red cape", "S-shield");
	}

	static class AssertHero {

		private Hero hero;

		public static AssertHero assertThatHero(Hero hero) {
			AssertHero assertHero = new AssertHero();
			assertHero.hero = hero;
			return assertHero;
		}

		public AssertHero hasAlias(String alias) {
			assertThat(hero.getAlias()).isEqualTo(alias);
			return this;
		}

		public AssertHero isCalled(String name, String lastName) {
			assertThat(hero.getRealFirstName()).isEqualTo(name);
			assertThat(hero.getRealLastName()).isEqualTo(lastName);
			return this;
		}

		public AssertHero comesFrom(HeroOrigin origin) {
			assertThat(hero.getOrigin()).isEqualTo(origin);
			return this;
		}

		public AssertHero hasSymbols(String... symbols) {
			assertThat(hero.getSymbols()).containsExactly(symbols);
			return this;
		}
	}
}
