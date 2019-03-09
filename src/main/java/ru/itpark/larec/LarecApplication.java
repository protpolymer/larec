package ru.itpark.larec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itpark.larec.entity.*;
import ru.itpark.larec.repository.*;

import java.util.List;

@SpringBootApplication
public class LarecApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(LarecApplication.class, args);
        var experimentRepository = context.getBean(ExperimentRepository.class);
        ExperimentEntity experiment1 = new ExperimentEntity(
                1,
                "C3H8O3 + CH4N2O = C4H6O4 + NH3",
                "Синтез глицеролкарбоната на цеолитах, модифицированных лантаном",
                "1.11.2016",
                null,
                null,
                "t = 423K; P = 1 bar",
                "Собрали установку.\n Загрузили реагенты.\n Подключили аргон.\n 12,30 - температура 150, присутствует запах аммиака\n",
                null,
                null,
                "Выход продукта 79%",
                "https://drive.google.com/open?id=0B5IpLUpjG6mKYjRKY1N2RkRYYkk");
        ExperimentEntity experiment2 = new ExperimentEntity(
                2,
                "C3H8O3 + CH4N2O = C4H6O4 + NH3",
                "Синтез глицеролкарбоната на аэросиле, модифицированным цинком (вакуум)",
                "04.04.2017",
                null,
                null,
                "t = 423K; P = 75 мм.рт.ст.",
                "Собрали установку.\n Загрузили реагенты.\n 9.00 - Т=140. Начало реакции\n 12.00 - установка выключена\n",
                null,
                null,
                "Показатели преломления:.\n - Реакционная масса = 1.9768\n - Этанол = 1.9838\n",
                "https://drive.google.com/open?id=1LMmKL1g3mX7UIj-FNa7_2DHhFpRkN4N_JuIjOEH1d-M");
        experimentRepository.saveAll(List.of(experiment1, experiment2));

        var reagentRepository = context.getBean(ReagentRepository.class);
        reagentRepository.saveAll(List.of(
                new ReagentEntity(
                        3,
                        experiment1,
                        "Глицерин",
                        92.09,
                        "C3H8O3",
                        "https://ru.wikipedia.org/wiki/%D0%93%D0%BB%D0%B8%D1%86%D0%B5%D1%80%D0%B8%D0%BD",
                        13.38
                ),
                new ReagentEntity(
                        4,
                        experiment1,
                        "Мочевина",
                        60.07,
                        "(NH2)2CO",
                        "https://ru.wikipedia.org/wiki/Мочевина",
                        6.2
                ),
                new ReagentEntity(
                        5,
                        experiment2,
                        "Глицерин",
                        92.09,
                        "C3H8O3",
                        "https://ru.wikipedia.org/wiki/%D0%93%D0%BB%D0%B8%D1%86%D0%B5%D1%80%D0%B8%D0%BD",
                        26.8
                ),
                new ReagentEntity(
                        6,
                        experiment2,
                        "Мочевина",
                        60.07,
                        "(NH2)2CO",
                        "https://ru.wikipedia.org/wiki/Мочевина",
                        12.4
                )
        ));

        var productRepository = context.getBean(ProductRepository.class);
        productRepository.saveAll(List.of(
                new ProductEntity(
                        7,
                        experiment1,
                        "Глицеролкарбонат",
                        118,
                        "C4H6O4",
                        "https://www.sciencedirect.com/topics/engineering/glycerol-carbonate",
                        0
                ),
                new ProductEntity(
                        8,
                        experiment2,
                        "Глицеролкарбонат",
                        118,
                        "C4H6O4",
                        "https://www.sciencedirect.com/topics/engineering/glycerol-carbonate",
                        70
                )
        ));

        var instrumentationRepository = context.getBean(InstrumentationRepository.class);
        instrumentationRepository.saveAll(List.of(
                new InstrumentationEntity(
                        9,
                        "Колба трехгорлая",
                        experiment1
                ),
                new InstrumentationEntity(
                        10,
                        "Термометр",
                        experiment1
                ),
                new InstrumentationEntity(
                        11,
                        "Капиляр",
                        experiment1
                ),
                new InstrumentationEntity(
                        12,
                        "Обратный холодильник",
                        experiment1
                ),
                new InstrumentationEntity(
                        13,
                        "Электроплита с магнитным перемешиванием",
                        experiment1
                ),
                new InstrumentationEntity(
                        13,
                        "Магнитный якорь",
                        experiment1
                ),
                new InstrumentationEntity(
                        14,
                        "Колба трехгорлая",
                        experiment2
                ),
                new InstrumentationEntity(
                        15,
                        "Термометр",
                        experiment2
                ),
                new InstrumentationEntity(
                        16,
                        "Обратный холодильник",
                        experiment2
                ),
                new InstrumentationEntity(
                        17,
                        "Электроплита с магнитным перемешиванием",
                        experiment2
                ),
                new InstrumentationEntity(
                        18,
                        "Магнитный якорь",
                        experiment2
                )
        ));

        var researcherRepository = context.getBean(ResearcherRepository.class);
        researcherRepository.saveAll(List.of(
                new ResearcherEntity(
                        19,
                        experiment1,
                        "Савин Николай Валерьевич",
                        23
                ),
                new ResearcherEntity(
                        20,
                        experiment1,
                        "Самуилов Яков Дмитриевич",
                        70
                ),
                new ResearcherEntity(
                        21,
                        experiment2,
                        "Савин Николай Валерьевич",
                        23
                ),
                new ResearcherEntity(
                        22,
                        experiment2,
                        "Самуилов Александр Яковлевич",
                        33
                )
        ));
    }

}
