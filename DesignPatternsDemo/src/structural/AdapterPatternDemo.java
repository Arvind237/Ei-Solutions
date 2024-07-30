package structural;

interface ModernDataSource {
    void readModernData();
}

class ModernDataSourceImpl implements ModernDataSource {
    public void readModernData() {
        System.out.println("Reading modern data");
    }
}

interface LegacyDataSource {
    void readLegacyData();
}

class LegacyDataSourceImpl implements LegacyDataSource {
    public void readLegacyData() {
        System.out.println("Reading legacy data");
    }
}

class LegacyToModernAdapter implements ModernDataSource {
    private LegacyDataSource legacyDataSource;

    public LegacyToModernAdapter(LegacyDataSource legacyDataSource) {
        this.legacyDataSource = legacyDataSource;
    }

    public void readModernData() {
        legacyDataSource.readLegacyData();
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        ModernDataSource modernDataSource = new ModernDataSourceImpl();
        modernDataSource.readModernData();

        LegacyDataSource legacyDataSource = new LegacyDataSourceImpl();
        ModernDataSource adaptedDataSource = new LegacyToModernAdapter(legacyDataSource);
        adaptedDataSource.readModernData();
    }
}
