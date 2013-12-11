package $7_data_setup;

import hero.Hero;
import hero.HeroOrigin;

public class HeroBuilder {

	private Hero hero;

	public static HeroBuilder aHero() {
		HeroBuilder heroBuilder = new HeroBuilder();
		heroBuilder.hero = new Hero()
				.alias("anyAlias")
				.realFirstName("anyFirstName")
				.realLastName("anyLastName")
				.origin(new HeroOrigin(1, "anyOrigin"));
		return heroBuilder;
	}

	public HeroBuilder withNoAlias() {
		hero.alias(null);
		return this;
	}

	public HeroBuilder withAlias(String alias) {
		hero.alias(alias);
		return this;
	}

	public HeroBuilder withFirstName(String firstName) {
		hero.realFirstName(firstName);
		return this;
	}

	public HeroBuilder withLastName(String lastName) {
		hero.realLastName(lastName);
		return this;
	}

	public HeroBuilder withOrigin(HeroOrigin origin) {
		hero.origin(origin);
		return this;
	}

	public Hero build() {
		return hero;
	}
}
