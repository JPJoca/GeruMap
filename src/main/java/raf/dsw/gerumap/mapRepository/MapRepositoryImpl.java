package raf.dsw.gerumap.mapRepository;

import raf.dsw.gerumap.core.MapRepository;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

import java.util.ArrayList;

public class MapRepositoryImpl implements MapRepository {

    private ProjectExplorer projectExplorer;

    public MapRepositoryImpl() {
        projectExplorer = new ProjectExplorer("Project Explorer");
    }

    @Override
    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }

}
