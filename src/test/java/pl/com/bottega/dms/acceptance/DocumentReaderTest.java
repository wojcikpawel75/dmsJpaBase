package pl.com.bottega.dms.acceptance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.com.bottega.dms.api.DocumentReader;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DocumentReaderTest {

    @Autowired
    private DocumentReader documentReader;

    @Test
    public void shouldReadDocuments() {

    }

}
