package uppgift_2;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IOUtilityTest {

    IOUtility ioUtility = new IOUtility();
    LocalDate todaysDate = LocalDate.now();

    Path inFile = Paths.get("test/uppgift_2/gym_medlemmar.txt");
    Path outFile = Paths.get("test/uppgift_2/pt_fil.txt");

    @Test
    public void readMemberFromFileTest() {

        List<Member> members = ioUtility.readMemberFromFile(inFile);

        assertEquals(20, members.size());
        assertNotEquals(21, members.size());

    }

    @Test
    public void readSpecificDataFromFile() {

        List<Member> members = ioUtility.readMemberFromFile(inFile);

        assertEquals("Fredrik Berggren", members.get(0).getName());
        assertNotEquals("Kalle Bergqvist", members.get(0).getName());

        assertEquals("851020-6728", members.get(0).getSocialSecurityNumber());
        assertNotEquals("940503-2648", members.get(0).getSocialSecurityNumber());

        assertEquals("2021-12-30", members.get(0).getMembershipUpdateDate());
        assertNotEquals("2023-12-30", members.get(0).getMembershipUpdateDate());

        assertEquals("Platina", members.get(0).getMemberLvl());
        assertNotEquals("Guld", members.get(0).getMemberLvl());

    }

    @Test
    public void writeDataToFileTest() throws IOException {

        if (Files.exists(outFile)) {
            Files.delete(outFile);
        }


        Member member = new Member("Pia Johansson", "Idrottsvägen 1, 77845 Landskrona",
                "anne31@fakemail.de", "361026-1822", "2024-07-18",
                "2025-07-18", "Standard");

        ioUtility.writeMemberToFile(outFile, member);
        ioUtility.writeMemberToFile(outFile, member);

        try (BufferedReader br = Files.newBufferedReader(outFile)) {

            br.readLine();
            String line = br.readLine();
            String[] parts = line.split(";");

            assertEquals("Pia Johansson", parts[0]);
            assertEquals("361026-1822", parts[1]);
            assertEquals(todaysDate.toString(), parts[2]);

            line = br.readLine();
            parts = line.split(";");

            assertEquals("Pia Johansson", parts[0]);
            assertEquals("361026-1822", parts[1]);
            assertEquals(todaysDate.toString(), parts[2]);


        }
    }
}