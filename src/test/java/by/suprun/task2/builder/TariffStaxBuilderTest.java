package by.suprun.task2.builder;

import by.suprun.task2.entity.AbstractTariff;
import by.suprun.task2.entity.InternetTariff;
import by.suprun.task2.entity.OperatorName;
import by.suprun.task2.entity.CallingTariff;
import by.suprun.task2.exception.TariffException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.fail;

public class TariffStaxBuilderTest {
    private static final String XML_FILE = "data/tariffs1.xml";
    private Set<AbstractTariff> expected;

    @BeforeClass
    public void setUp(){
        expected = new HashSet<>();

        expected.add(new CallingTariff("MEG_37540-314-9479",
                "light",
                OperatorName.MEGAFON,
                32,
                3,
                0,
                LocalDate.parse("2022-03-01"),
                3,
                2,
                2,
                3));

        expected.add(new InternetTariff("MTS_37534-314-9471",
                "Standard",
                OperatorName.MTS,
                35,
                15,
                0,
                LocalDate.parse("2022-03-01"),
                56000,
                1,
                4,
                4000));
    }

    @Test
    public void TestTariffStaxBuilder(){
        AbstractTariffBuilder builder;
        Set<AbstractTariff> actual = null;
        try {
            builder = TariffBuilderFactory.getInstance().createTariffBuilder(ParserType.STAX);
            builder.buildTariffs(XML_FILE);
            actual = builder.getTariffs();
        }catch (TariffException e){
            fail(e.getMessage());
        }
        assertEquals(expected.containsAll(actual), actual.containsAll(expected));
    }
}
