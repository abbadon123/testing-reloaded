package $9_legacy_code;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static legacy_code.Validator.isNull;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(JUnitParamsRunner.class)
public class LegacyCodeTest {

	@Test
	public void shouldReturnTrueForNull() {
		boolean isNull = isNull(null);
		assertThat(isNull).isTrue();
	}

	@Parameters({"null", "", " ", " n u l  l "})
	@Test
	public void shouldReturnTrue(String value) {
		boolean isNull = isNull(value);
		assertThat(isNull).isTrue();
	}

	@Test
	@Parameters({"\t", "a", " B ", "n", "nu", "nul", "\n", "\r", "\r\n"})
	public void shouldNotBeNull(String value) {
		assertThat(isNull(value)).isFalse();
	}

}
