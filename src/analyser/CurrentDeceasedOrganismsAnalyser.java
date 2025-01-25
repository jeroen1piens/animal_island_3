package analyser;

import simulation.*;

import java.util.stream.Collectors;

public class CurrentDeceasedOrganismsAnalyser extends CurrentOrganismsAnalyser {

    @Override
    public int getBearCount() {
        return allOrganismsSet.stream()
                .filter(organism -> organism instanceof Bear)
                .filter(organism -> !organism.isAlive())
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public int getBoaCount() {
        return allOrganismsSet.stream()
                .filter(organism -> organism instanceof Boa)
                .filter(organism -> !organism.isAlive())
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public int getBoarCount() {
        return allOrganismsSet.stream()
                .filter(organism -> organism instanceof Boar)
                .filter(organism -> !organism.isAlive())
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public int getBuffaloCount() {
        return allOrganismsSet.stream()
                .filter(organism -> organism instanceof Buffalo)
                .filter(organism -> !organism.isAlive())
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public int getCaterpillarCount() {
        return allOrganismsSet.stream()
                .filter(organism -> organism instanceof Caterpillar)
                .filter(organism -> !organism.isAlive())
                .collect(Collectors.toSet())
                .size();

    }

    @Override
    public int getDeerCount() {
        return allOrganismsSet.stream()
                .filter(organism -> organism instanceof Deer)
                .filter(organism -> !organism.isAlive())
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public int getDuckCount() {
        return allOrganismsSet.stream()
                .filter(organism -> organism instanceof Duck)
                .filter(organism -> !organism.isAlive())
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public int getEagleCount() {
        return allOrganismsSet.stream()
                .filter(organism -> organism instanceof Eagle)
                .filter(organism -> !organism.isAlive())
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public int getFoxCount() {
        return allOrganismsSet.stream()
                .filter(organism -> organism instanceof Fox)
                .filter(organism -> !organism.isAlive())
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public int getGoatCount() {
        return allOrganismsSet.stream()
                .filter(organism -> organism instanceof Goat)
                .filter(organism -> !organism.isAlive())
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public int getHorseCount() {
        return allOrganismsSet.stream()
                .filter(organism -> organism instanceof Horse)
                .filter(organism -> !organism.isAlive())
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public int getMouseCount() {
        return allOrganismsSet.stream()
                .filter(organism -> organism instanceof Mouse)
                .filter(organism -> !organism.isAlive())
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public int getPlantCount() {
        return allOrganismsSet.stream()
                .filter(organism -> organism instanceof Plant)
                .filter(organism -> !organism.isAlive())
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public int getRabbitCount() {
        return allOrganismsSet.stream()
                .filter(organism -> organism instanceof Rabbit)
                .filter(organism -> !organism.isAlive())
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public int getSheepCount() {
        return allOrganismsSet.stream()
                .filter(organism -> organism instanceof Sheep)
                .filter(organism -> !organism.isAlive())
                .collect(Collectors.toSet())
                .size();
    }

    @Override
    public int getWolfCount() {
        return allOrganismsSet.stream()
                .filter(organism -> organism instanceof Wolf)
                .filter(organism -> !organism.isAlive())
                .collect(Collectors.toSet())
                .size();
    }
}
