package sum25.tinth.homework.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sum25.tinth.homework.pojo.Account;
import sum25.tinth.homework.pojo.Category;
import sum25.tinth.homework.pojo.Orchid;
import sum25.tinth.homework.pojo.Role;
import sum25.tinth.homework.repository.AccountRepository;
import sum25.tinth.homework.repository.CategoryRepository;
import sum25.tinth.homework.repository.OrchidRepository;
import sum25.tinth.homework.repository.RoleRepository;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private OrchidRepository orchidRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        // Initialize roles
        if (roleRepository.count() == 0) {
            roleRepository.save(new Role("ADMIN"));
            roleRepository.save(new Role("CUSTOMER"));
        }

        // Initialize categories
        // Categories mới
        if (categoryRepository.count() == 0) {
            categoryRepository.save(new Category("Lan Vanda"));
            categoryRepository.save(new Category("Lan Miltonia"));
            categoryRepository.save(new Category("Lan Mokara"));
            categoryRepository.save(new Category("Lan Phalaenopsis"));
        }

        if (orchidRepository.count() == 0) {
            // Lấy lại các category đã tạo
            Category cat1 = categoryRepository.save(new Category("Lan Vanda"));
            Category cat2 = categoryRepository.save(new Category("Lan Miltonia"));
            Category cat3 = categoryRepository.save(new Category("Lan Mokara"));
            Category cat4 = categoryRepository.save(new Category("Lan Phalaenopsis"));

            // Lan Vanda (4 loại)
            orchidRepository.save(new Orchid("Vanda Xanh Dương", "Lan Vanda xanh dương hiếm, cánh to, màu độc lạ.", new BigDecimal("215000"), true, "/image/vandaxanhduong.jpg", cat1));
            orchidRepository.save(new Orchid("Vanda Cam Hoàng Hôn", "Vanda màu cam rực rỡ như ánh hoàng hôn.", new BigDecimal("230000"), false, "/image/vandahoanghon.jpg", cat1));
            orchidRepository.save(new Orchid("Vanda Hồng Phấn", "Vanda hồng nhẹ, hoa lâu tàn, thích hợp trang trí.", new BigDecimal("240000"), true, "/image/vandahongphan.jpg", cat1));
            orchidRepository.save(new Orchid("Vanda Tím Nhung", "Vanda tím đậm, cánh hoa dày, bền màu.", new BigDecimal("250000"), true, "/image/vandatimnhung.jpg", cat1));

            // Lan Miltonia (4 loại)
            orchidRepository.save(new Orchid("Miltonia Tuyết Mai", "Miltonia trắng như tuyết, hương thơm nhẹ.", new BigDecimal("180000"), true, "/image/miltoniatuyetmai.jpg", cat2));
            orchidRepository.save(new Orchid("Miltonia Sương Sớm", "Miltonia màu tím nhạt, hoa nở thành chùm.", new BigDecimal("188000"), false, "/image/miltoniasuongsom.jpg", cat2));
            orchidRepository.save(new Orchid("Miltonia Nắng Sớm", "Miltonia vàng nhạt, bền, dễ chăm sóc.", new BigDecimal("196000"), true, "/image/miltonianangsom.jpg", cat2));
            orchidRepository.save(new Orchid("Miltonia Đỏ Tươi", "Miltonia đỏ rực, nở quanh năm, nổi bật.", new BigDecimal("205000"), true, "/image/dotuoi.jpg", cat2));

            // Lan Mokara (4 loại)
            orchidRepository.save(new Orchid("Mokara Hoàng Gia", "Mokara vàng óng, hoa nở dày đặc.", new BigDecimal("200000"), true, "/image/hoanggia.jpg", cat3));
            orchidRepository.save(new Orchid("Mokara Nắng Ấm", "Mokara cam tươi, dễ trồng, phù hợp mọi không gian.", new BigDecimal("210000"), false, "/image/mokananangam.jpg", cat3));
            orchidRepository.save(new Orchid("Mokara Hồng Đào", "Mokara hồng đào, cánh mỏng, nhẹ nhàng.", new BigDecimal("220000"), true, "/image/mokarahongdao.jpg", cat3));
            orchidRepository.save(new Orchid("Mokara Tím Ngọc", "Mokara tím lạ mắt, hoa nhỏ, lâu tàn.", new BigDecimal("225000"), true, "/image/mokarahongngoc.jpg", cat3));

            // Lan Phalaenopsis (4 loại)
            orchidRepository.save(new Orchid("Phalaenopsis Tuyết Đan", "Phalaenopsis trắng mịn, sang trọng.", new BigDecimal("195000"), true, "/image/Phalaenopsistuyetdan.jpg", cat4));
            orchidRepository.save(new Orchid("Phalaenopsis Vàng Tươi", "Phalaenopsis vàng tươi như ánh mặt trời.", new BigDecimal("210000"), false, "/image/vangtuoi.jpg", cat4));
            orchidRepository.save(new Orchid("Phalaenopsis Cam Nhẹ", "Phalaenopsis cam nhạt, hoa lớn, lâu tàn.", new BigDecimal("200000"), true, "/image/cam nhe.jpg", cat4));
            orchidRepository.save(new Orchid("Phalaenopsis Tím Nhạt", "Phalaenopsis tím nhẹ, hoa bền.", new BigDecimal("205000"), true, "/image/timnhat.jpg", cat4));
        }

        if (accountRepository.count() == 0) {
            Role adminRole = roleRepository.findByRoleName("ADMIN").orElse(null);
            Role customerRole = roleRepository.findByRoleName("CUSTOMER").orElse(null);

            // Manager account
            Account admin = new Account(
                    "Ngô Văn Quản Lý",
                    "admin@gmail.com",
                    "admin123",
                    adminRole
            );
            accountRepository.save(admin);

            // 5 user mới
            accountRepository.save(new Account(
                    "Trần Minh Nhật",
                    "nhattran@gmail.com",
                    "nhat123",
                    customerRole
            ));
            accountRepository.save(new Account(
                    "Bùi Thị Thảo",
                    "thaobui@gmail.com",
                    "thao123",
                    customerRole
            ));
            accountRepository.save(new Account(
                    "Võ Hoàng Anh",
                    "anhvo@gmail.com",
                    "anh123",
                    customerRole
            ));
            accountRepository.save(new Account(
                    "Lê Khánh Duy",
                    "duyle@gmail.com",
                    "duy123",
                    customerRole
            ));
            accountRepository.save(new Account(
                    "Đặng Thùy Trang",
                    "trangdt@gmail.com",
                    "trang123",
                    customerRole
            ));
        }


    }
}
