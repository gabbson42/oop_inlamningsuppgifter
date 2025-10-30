package uppgift_2;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    Member member = new Member("Fredrik Berggren", "Skolgränd 8, 16819 Norrköping",
            "fredde@fakemail.se", "851020-6728", "2019-12-30",
            "2021-12-30", "Platina");

    @Test
    public void getNameTest(){

        assertEquals("Fredrik Berggren", member.getName());
        assertNotEquals("Kalle Bergqvist", member.getName());

    }

    @Test
    public void getAddressTest(){

        assertEquals("Skolgränd 8, 16819 Norrköping", member.getAddress());
        assertNotEquals("Fakegränd 7, 17645 Fakeköping", member.getAddress());

    }

    @Test
    public void getEmailTest(){

        assertEquals("fredde@fakemail.se", member.getEmail());
        assertNotEquals("kalle@fakemail.se", member.getEmail());

    }

    @Test
    public void getSocialSecurityNumberTest(){

        assertEquals("851020-6728", member.getSocialSecurityNumber());
        assertNotEquals("940503-2648", member.getSocialSecurityNumber());

    }

    @Test
    public void getJoinDateTest(){

        assertEquals("2019-12-30", member.getJoinDate());
        assertNotEquals("2020-12-30", member.getJoinDate());

    }

    @Test
    public void getMembershipUpdateDateTest(){

        assertEquals("2021-12-30", member.getMembershipUpdateDate());
        assertNotEquals("2023-12-30", member.getMembershipUpdateDate());

    }

    @Test
    public void getMemberLvlTest(){

        assertEquals("Platina", member.getMemberLvl());
        assertNotEquals("Guld", member.getMemberLvl());

    }

    @Test
    public void isActiveMemberTest(){

        Member member1 = new Member("Pia Johansson", "Idrottsvägen 1, 77845 Landskrona",
                "anne31@fakemail.de", "361026-1822", "2024-07-18",
                "2025-07-18", "Standard");
        Member member2 = new Member("Fredrik Berggren", "Skolgränd 8, 16819 Norrköping",
                "fredde@fakemail.se", "851020-6728", "2019-12-30",
                "2024-10-20", "Platina");


        LocalDate dateToday = LocalDate.parse("2025-10-21");

        assertTrue(member1.isActiveMember(dateToday));
        assertFalse(member2.isActiveMember(dateToday));
    }

}