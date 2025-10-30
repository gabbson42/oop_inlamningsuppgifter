package uppgift_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IOUtility {

    private List<Member> memberList;

    public List<Member> readMemberFromFile(Path inFile){

        this.memberList = new ArrayList<>();

        try(BufferedReader br = Files.newBufferedReader(inFile)){

            String line;
            br.readLine();
            while((line = br.readLine()) != null) {
                String [] parts = line.split(";");

                Member member = new Member(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
                this.memberList.add(member);
            }

        } catch (IOException e) {
            IO.println("Fel inträffade vid läsning från fil");
            e.printStackTrace();
            System.exit(0);
        }

        return memberList;
    }

    public void writeMemberToFile(Path outFile, Member member){

        String memberInfo = member.getName() + ";" + member.getSocialSecurityNumber() + ";" + LocalDate.now();

        try {
            boolean fileIsEmpty = !Files.exists(outFile) || Files.size(outFile) == 0;

            try (BufferedWriter bw = Files.newBufferedWriter(outFile,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {

                if (fileIsEmpty) {
                    bw.append("Medlem;Personnummer;Besöksdatum");
                    bw.newLine();
                }
                bw.append(memberInfo);
                bw.newLine();
            }
        }
        catch(IOException e){
            IO.println("Fel inträffade vid skrivning till fil");
            e.printStackTrace();
            System.exit(0);
        }

    }
}
