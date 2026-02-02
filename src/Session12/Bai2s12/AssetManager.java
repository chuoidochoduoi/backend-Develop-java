package Session12.Bai2s12;

import java.util.ArrayList;
import java.util.List;

class AssetManager {
    private List<Asset> list = new ArrayList<>();

    // Tính Đa hình: Nhận vào một Asset (có thể là Computer hoặc NetworkDevice)
    public void showValue(Asset a) {
        System.out.println(a.toString() + " | Giá trị hiện tại: " + a.getMarketValue());
    }

    // Overloading: Tìm theo mã (String)
    public void search(String code) {
        for (Asset a : list) {
            if (a.assetCode.equalsIgnoreCase(code)) showValue(a);
        }
    }

    // Overloading: Tìm theo giá mua (double)
    public void search(double minPrice) {
        for (Asset a : list) {
            if (a.purchasePrice > minPrice) showValue(a);
        }
    }

    public void addAsset(Asset a) { list.add(a); }
    public List<Asset> getList() { return list; }
}