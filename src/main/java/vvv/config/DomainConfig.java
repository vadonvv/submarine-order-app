package vvv.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vvv.domain.Submarine;
import vvv.domain.SubmarineList;
import vvv.domain.SubmarinePart;

@Configuration
public class DomainConfig {
    @Bean
    @Qualifier("1")
    public SubmarineList getSubmarineList(){
        SubmarineList submarineList = new SubmarineList();
        submarineList.addSubmarine(new Submarine("First"));
        submarineList.addSubmarine(new Submarine("Second"));
        submarineList.addSubmarine(new Submarine("Wierd"));

        Submarine submarine = new Submarine("Final");
        submarine.addPart(new SubmarinePart("engine",100,1));
        submarine.addPart(new SubmarinePart("oxigen system",20,2));
        submarine.addPart(new SubmarinePart("hull",200,1));
        submarine.addPart(new SubmarinePart("fuel tank",5,2));
        submarineList.addSubmarine(submarine);
        return submarineList;
    }
}
