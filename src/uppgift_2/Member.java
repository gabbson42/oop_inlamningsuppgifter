package uppgift_2;

import java.time.LocalDate;

public class Member {

    private final String name;
    private final String address;
    private final String email;
    private final String socialSecurityNumber;
    private final String joinDate;
    private final String membershipUpdateDate;
    private final String memberLvl;

    public Member(String name, String address, String email, String ssNr,
                  String joinDate, String updDate, String memberLvl){
        this.name = name;
        this.address = address;
        this.email = email;
        this.socialSecurityNumber = ssNr;
        this.joinDate = joinDate;
        this.membershipUpdateDate = updDate;
        this. memberLvl = memberLvl;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public String getMembershipUpdateDate() {
        return membershipUpdateDate;
    }

    public String getMemberLvl() {
        return memberLvl;
    }

    public boolean isActiveMember(){
        return isActiveMember(LocalDate.now());
    }

    public boolean isActiveMember(LocalDate dateToday){

        LocalDate membershipUpdateDate = LocalDate.parse(getMembershipUpdateDate());
        LocalDate membershipExpireDate = membershipUpdateDate.plusYears(1);

        return !dateToday.isAfter(membershipExpireDate);
    }
}
