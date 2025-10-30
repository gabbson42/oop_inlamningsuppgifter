package uppgift_2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

    /* Exempelpersoner: gustav johansson, 361026-1822, Oskar Bengtsson */

    public Main() {

        Path inFile = Paths.get("src/uppgift_2/gym_medlemmar.txt");
        Path outFile = Paths.get("src/uppgift_2/pt_fil.txt");

        Scanner sc = new Scanner(System.in);
        IOUtility ioU = new IOUtility();

        List<Member> members = ioU.readMemberFromFile(inFile);

        while (true) {

            IO.println("Vem ska checkas in? Skriv fullt namn eller personnummer. Skriv exit för att avsluta.");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                return;
            }

            if (input.isBlank()) {
                IO.println("Du måste fylla i namn eller personnummer.");
                pressEnterToContinue(sc);
                continue;
            }

            boolean isMember = false;
            for (Member member : members) {
                if (input.equalsIgnoreCase(member.getName()) ||
                        input.equalsIgnoreCase(member.getSocialSecurityNumber())) {

                    isMember = true;
                    if (member.isActiveMember()) {
                        IO.println("Personen är en aktiv medlem med giltigt medlemsskap.");
                        IO.println("Medlemsnivå: " + member.getMemberLvl());
                        ioU.writeMemberToFile(outFile, member);
                        pressEnterToContinue(sc);
                    } else {
                        IO.println("Personen är en före detta kund utan giltigt medlemsskap.");
                        pressEnterToContinue(sc);
                    }
                    break;
                }
            }
            if (!isMember) {
                IO.println("Personen är ej medlem hos oss.");
                pressEnterToContinue(sc);
            }

        }
    }

    public static void pressEnterToContinue(Scanner sc){
        IO.println();
        IO.println("Tryck Enter för att fortsätta.");
        sc.nextLine();

    }

    static void main() {
        Main run = new Main();
    }
}
