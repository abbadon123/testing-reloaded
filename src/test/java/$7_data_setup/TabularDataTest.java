package $7_data_setup;

import data_setup.HeroRowMapper;
import hero.Hero;
import hero.HeroOrigin;
import java.sql.ResultSet;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TabularDataTest {

    private ResultSet rs = mock(ResultSet.class);
    private HeroRowMapper mapper = new HeroRowMapper();

	private void isRow(String alias, String name, String lastName, int origin, String city) throws Exception {
		when(rs.getString(1)).thenReturn(alias);
        when(rs.getString(2)).thenReturn(name);
        when(rs.getString(3)).thenReturn(lastName);
        when(rs.getInt(4)).thenReturn(origin);
        when(rs.getString(5)).thenReturn(city);
	}

    @Test
    public void map_hero_with_origin() throws Exception {
		isRow("Batman", "Bruce", "Wayne", 11, "Gotham City");

        Hero hero = mapper.mapRow(rs, 0);

        assertThat(hero.getAlias()).isEqualTo("Batman");
        assertThat(hero.getRealFirstName()).isEqualTo("Bruce");
        assertThat(hero.getRealLastName()).isEqualTo("Wayne");
        assertThat(hero.getOrigin()).isEqualTo(new HeroOrigin(11, "Gotham City"));
    }

    @Test
    public void map_hero_with_no_alias() throws Exception {
		isRow(null, "Sherlock", "Holmes", 12, "London");

        Hero hero = mapper.mapRow(rs, 0);

        assertThat(hero.getAlias()).isNull();
        assertThat(hero.getRealFirstName()).isEqualTo("Sherlock");
        assertThat(hero.getRealLastName()).isEqualTo("Holmes");
        assertThat(hero.getOrigin()).isEqualTo(new HeroOrigin(12, "London"));
    }


}
