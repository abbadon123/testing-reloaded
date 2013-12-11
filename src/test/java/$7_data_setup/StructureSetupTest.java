package $7_data_setup;

import data_setup.EpitaphWriter;
import hero.Hero;
import hero.HeroOrigin;
import org.junit.Test;

import static $7_data_setup.HeroBuilder.aHero;
import static org.assertj.core.api.Assertions.*;

public class StructureSetupTest {

    private EpitaphWriter epitaphWriter = new EpitaphWriter();

    @Test
    public void epitaph_for_any_hero() {
        Hero anyHero = aHero().withAlias("Batman").build();

        String epitaph = epitaphWriter.epitaphFor(anyHero);

        assertThat(epitaph).isEqualTo("Batman is dead");
    }

    @Test
    public void epitaph_for_hero_from_Germany() {
		Hero heroFromGermany = aHero()
				.withAlias("Doctor Octopus")
				.withOrigin(HeroOrigin.GERMANY).build();

        String epitaph = epitaphWriter.epitaphFor(heroFromGermany);

        assertThat(epitaph).isEqualTo("Doctor Octopus ist tot");
    }

    @Test
    public void epitaph_for_hero_known_by_his_real_name() {
        Hero heroWithNoAlias = aHero()
				.withNoAlias()
				.withFirstName("Sherlock")
				.withLastName("Holmes").build();

        String epitaph = epitaphWriter.epitaphFor(heroWithNoAlias);

        assertThat(epitaph).isEqualTo("Sherlock Holmes is dead");
    }

}
