package com.example.and11_allview.listfrag;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.and11_allview.ListDTO;
import com.example.and11_allview.ListFDTO;
import com.example.and11_allview.ListF_Adapter;
import com.example.and11_allview.R;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    ListView list_frag;
    ArrayList<ListFDTO> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        list_frag = v.findViewById(R.id.listv_frag);

        list.add(new ListFDTO("굴", "바다의 우유라 불리는 굴은 영양이 가득한 재료입니다. 바다의 맛도 챙기고 건강도 챙기는 일석이조 먹거리! 카사노바도 즐겨먹었다는 건강 먹거리랍니다.", R.drawable.oysters_640));
        list.add(new ListFDTO("사과", "미국의 대표적인 후식으로 꼽히는 사과파이. 유럽에서 소시지나 돼지고기 요리에 곁들이는 튀긴 사과. 과일 자체로도 달콤한 맛이 좋은 인기만점 과일의 여왕 사과입니다.",R.drawable.apples_640));
        list.add(new ListFDTO("홍합", "추운 겨울 따뜻한 국물이 최고에요. 포장마차에서 즐겨 먹는 뽀얀 국물에 담백한 맛까지 섞여 있는 시원한 홍합탕은 서민들의 속을 풀어주는 대표적인 술안주인데요. 칼슘, 인, 철분 등이 풍부하게 들어 있는 홍합을 소개합니다.",R.drawable.shellfish_640));
        list.add(new ListFDTO("꼬막", "겨울 되면 시장에 나오기시작하는 꼬막은 겨울 입맛을 깨우는 별미로 제격입니다. 아미노산이 풍부한 꼬막으로 입맛을 회복해 보세요.",R.drawable.shell_640));
        list.add(new ListFDTO("배추", "한국인의 자랑스런 먹거리 김치는 배추없이는 만들 수 없습니다. 잎, 줄기, 뿌리를 모두 식용하며, 비타민이 풍부하게 함유되어 있어 버릴것이 없는 채소랍니다.",R.drawable.cabbage_640));
        list.add(new ListFDTO("무", "가을 수확 후 겨울내 땅속에 묻어두고 하나씩 꺼내먹던 무. 시원하고 달콤한 무를 기억하시나요? 비타민 C가 풍부하고 겨울철이 제철인 무로 다양한 요리를 해보세요.",R.drawable.white_radish_640));
        list.add(new ListFDTO("늙은호박", "아기를 낳으면 늙은호박을 고와 그 물을 마시는데요. 호박물은 산후 부기를 제거하는 탁월한 효능을 가지고 있답니다.",R.drawable.pumpkin_640));
        list.add(new ListFDTO("대하", "구워도 맛있고, 새우튀김으로 먹어도 맛있는 키토산이 가득한 대하에 대해 알아봅니다.",R.drawable.shrimp_640));
        list.add(new ListFDTO("유자", "유자는 겨울을 알리는 전령사로 향기롭고 따뜻한 유자차는 찬바람이 도는 겨울철에 자주 찾게 되는 차인데요. 비타민 C가 풍부한 유자로 건강을 챙기세요. 감기에도 좋답니다.",R.drawable.citron_640));
        list.add(new ListFDTO("명태", "지방의 함량이 낮고 담백한 맛을 자랑하는 명태. 명태의 어원은 함경도 관찰사로 부임한 민 아무개가 명천군을 방문했다가 식사를 하는데, 식탁에 오른 생선이 맛있어 이름을 묻자 이름이 없다고 말했대요. 그래서 명천군의 ‘명’자와 고기를 잡은 어부 태 씨의 ‘태’자를 따서 ‘명태’라는 이름을 지었다고 합니다.",R.drawable.pollock_640));

        ListF_Adapter listF_adapter = new ListF_Adapter(getLayoutInflater(),list);
        list_frag.setAdapter(listF_adapter);

        return v;
    }
}