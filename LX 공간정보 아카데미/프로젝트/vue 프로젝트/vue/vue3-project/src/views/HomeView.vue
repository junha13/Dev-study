<template>
  <div class="app-page flex-column flex-column-fluid" id="kt_app_page">
    <div>
      <h1>홈화면</h1>
    </div>
    <div class="row">
      <div class="col-xl-2">

      </div>
      <div class="d-flex align-items-center justify-content-center">
      <div class="col-xl-8">
        <!--begin::Table widget 14-->
        <div class="card card-flush h-md-100">
          <!--begin::Header-->
          <div class="card-header pt-7">
            <!--begin::Title-->
            <h3 class="card-title align-items-start flex-column">
              <span class="card-label fw-bold text-gray-800">고객 목록</span>
              <span class="text-gray-500 mt-1 fw-semibold fs-6">37분전 업데이트</span>
            </h3>
            <!--end::Title-->
            <!--begin::Toolbar-->
            <div class="card-toolbar">
              <a href="apps/ecommerce/catalog/add-product.html" class="btn btn-sm btn-light">문의 이력</a>
            </div>
            <!--end::Toolbar-->
          </div>
          <!--end::Header-->
          <!--begin::Body-->
          <div class="card-body pt-6">
            <!--begin::Table container-->
            <div class="table-responsive">
              <!--begin::Table-->
              <table class="table table-row-dashed align-middle gs-0 gy-3 my-0">
                <!--begin::Table head-->
                <thead>
                  <tr class="fs-7 fw-bold text-gray-500 border-bottom-0">
                    <th class="p-0 pb-3 min-w-175px text-start">이름</th>
                    <th class="p-0 pb-3 min-w-100px text-end">나이</th>
                    <th class="p-0 pb-3 min-w-100px text-end">전번</th>
                    <th class="p-0 pb-3 min-w-175px text-end pe-12">상태</th>
                    <th class="p-0 pb-3 w-50px text-end">상세보기</th>
                  </tr>
                </thead>
                <!--end::Table head-->
                <!--begin::Table body-->
                <tbody>
                  <tr>
                    <td>
                      <div class="d-flex align-items-center">
                        <div class="symbol symbol-40px me-3">
                          <img src="/assets/media/stock/600x600/img-49.jpg" class="" alt="" /> <!--링크에 /붙혀서 될 수도 있음 public으로 옮겼으니까-->
                        </div>
                        <div class="d-flex justify-content-start flex-column">
                          <a href="#" class="text-gray-800 fw-bold text-hover-primary mb-1 fs-6">홍길동1</a>
                          <span class="text-gray-500 fw-semibold d-block fs-7">남성</span>
                        </div>
                      </div>
                    </td>
                    <td class="text-end pe-0">
                      <span class="text-gray-600 fw-bold fs-6">22</span>
                    </td>
                    <td class="text-end pe-0">
                      <!--begin::Label-->
                      <span class="badge badge-light-success fs-base">
                      <i class="ki-outline ki-arrow-up fs-5 text-success ms-n1"></i>010-1000-1000</span>
                      <!--end::Label-->
                    </td>
                    <td class="text-end pe-12">
                      <span class="badge py-3 px-4 fs-7 badge-light-primary">진행중</span>
                    </td>
                    <td class="text-end">
                      <a href="#" class="btn btn-sm btn-icon btn-bg-light btn-active-color-primary w-30px h-30px">
                        <i class="ki-outline ki-black-right fs-2 text-gray-500"></i>
                      </a>
                    </td>
                  </tr>
                  
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
      </div>
      <div class="col-xl-2">

      </div>
    </div>
  </div>

</template>


<script setup>

</script>

<style scoped>

</style>

