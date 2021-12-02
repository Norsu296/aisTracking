package com.kuba.aistracking.data;

import com.kuba.aistracking.model.entity.Base;
import com.kuba.aistracking.model.entity.Rocket;
import com.kuba.aistracking.repository.BaseRepository;
import com.kuba.aistracking.repository.RocketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final BaseRepository baseRepository;
    private final RocketRepository rocketRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Rocket rocket1 = new Rocket();
        Rocket rocket2 = new Rocket();
        Rocket rocket3 = new Rocket();
        Rocket rocket4 = new Rocket();
        Rocket rocket5 = new Rocket();

        rocket1.setName("ZXT-1000");
        rocket1.setRange(50000);

        rocket2.setName("SVT200");
        rocket2.setRange(2500);

        rocket3.setName("TOM2");
        rocket3.setRange(35000);

        rocket4.setName("SGB67");
        rocket4.setRange(1500000);

        rocket5.setName("LRAD1234");
        rocket5.setRange(9999);

        rocketRepository.save(rocket1);
        rocketRepository.save(rocket2);
        rocketRepository.save(rocket3);
        rocketRepository.save(rocket4);
        rocketRepository.save(rocket5);

        Base base1 = new Base();
        Base base2 = new Base();
        Base base3 = new Base();
        Base base4 = new Base();
        Base base5 = new Base();
        Base base6 = new Base();

        base1.setName("FGH-Borsa");
        base1.setPositionY(10.06606228828895);
        base1.setPositionX(63.32771850658376);

        base2.setName("RXT-Vessel");
        base2.setPositionY(10.85243);
        base2.setPositionX(63.32990);

        base3.setName("Guardian");
        base3.setPositionY(10.53537);
        base3.setPositionX(63.16149);

        base4.setName("Loc");
        base4.setPositionY(10.42083);
        base4.setPositionX(63.44273);

        base5.setName("FGH-Vessel");
        base5.setPositionY(10.49904);
        base5.setPositionX(63.57561);

        base6.setName("FGH-Vessel");
        base6.setPositionY(10.87487);
        base6.setPositionX(63.57658);

        baseRepository.save(base1);
        baseRepository.save(base2);
        baseRepository.save(base3);
        baseRepository.save(base4);
        baseRepository.save(base5);
        baseRepository.save(base6);

    }
}

