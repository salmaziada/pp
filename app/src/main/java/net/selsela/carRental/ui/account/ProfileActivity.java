package net.selsela.carRental.ui.account;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.features.ReturnMode;
import com.esafirm.imagepicker.model.Image;
import com.github.siyamed.shapeimageview.RoundedImageView;

import net.selsela.carRental.R;
import net.selsela.carRental.ui.base.BaseActivity;
import net.selsela.carRental.util.Permissions;
import net.selsela.carRental.util.ViewUtil;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static net.selsela.carRental.util.Permissions.REQUEST_EXTERNAL_STORAGE;
import static net.selsela.carRental.util.ViewUtil.getResizedBitmap;
import static net.selsela.carRental.util.ViewUtil.modifyOrientation;

public class ProfileActivity extends BaseActivity {


    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.user_image_view)
    RoundedImageView userImageView;
    @BindView(R.id.upload_image)
    ImageView uploadImage;
    @BindView(R.id.name_label)
    TextView nameLabel;
    @BindView(R.id.name_edit)
    AppCompatEditText nameEdit;
    @BindView(R.id.eamil_label)
    TextView eamilLabel;
    @BindView(R.id.email_editText)
    AppCompatEditText emailEditText;
    @BindView(R.id.mobile)
    TextView mobile;
    @BindView(R.id.mobile_editText)
    EditText mobileEditText;
    @BindView(R.id.country_key)
    TextView countryKey;
    @BindView(R.id.mobile_lay)
    ConstraintLayout mobileLay;
    @BindView(R.id.change_pass_lay)
    ConstraintLayout changePassLay;
    @BindView(R.id.save_btn)
    Button saveBtn;
    private BottomSheetDialog bottomSheetDialog;
    private static final int IMG_RESULT = 1;
    String ImageDecode;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);

        activityTitle = getString(R.string.my_accounts);
        initToolbar();
        //FillwithUserData();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.save_imageView:
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    private void bottom_sheet_update_password() {
        bottomSheetDialog = new BottomSheetDialog(this);
        View sheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_update_password, null);

        bottomSheetDialog.setContentView(sheetView);
        bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackground(getResources().getDrawable(R.drawable.shape_button_sheet_background));
//        final AppCompatEditText currentPass = bottomSheetDialog.findViewById(R.id.current_pass);
//        final AppCompatEditText newPass = bottomSheetDialog.findViewById(R.id.new_pass);
//        final AppCompatEditText confirmPass = bottomSheetDialog.findViewById(R.id.confirm_pass);

        BottomSheetBehavior mBottomSheetBehavior = BottomSheetBehavior.from(((View) sheetView.getParent()));
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        mBottomSheetBehavior.setSkipCollapsed(true);

        final Button save_btn = bottomSheetDialog.findViewById(R.id.save_btn);
        final ImageView dismiss_action = bottomSheetDialog.findViewById(R.id.dismiss_action);

        dismiss_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();


            }
        });

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.show();

    }

    @Override
    public void isSuccess(Boolean status) {

    }


    private boolean checkPasswordData(AppCompatEditText currentPass, AppCompatEditText newPass, AppCompatEditText confirmPass) {
        if (TextUtils.isEmpty(currentPass.getText())) {
            ViewUtil.setError(currentPass);
            return false;
        }

        if (TextUtils.isEmpty(newPass.getText())) {
            ViewUtil.setError(newPass);
            return false;
        } else {
            if (!newPass.getText().toString().equals(confirmPass.getText().toString())) {
                ViewUtil.isPasswordsMatches(newPass, confirmPass);
                return false;
            }
        }


        return true;
    }

    @OnClick({R.id.change_pass_lay, R.id.save_btn,R.id.upload_image})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.change_pass_lay:
                bottom_sheet_update_password();
                break;
            case R.id.save_btn:
                break;
            case R.id.upload_image:
                if (!Permissions.checkWriteExternalPermission(this))
                    Permissions.verifyStoragePermissions(this);
                else openGallery();
                break;
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {

            if (requestCode == IMG_RESULT && resultCode == RESULT_OK
                    && null != data) {
                Image selectedImage = ImagePicker.getFirstImageOrNull(data);
                ImageDecode = ViewUtil.resizeAndCompressImageBeforeSend(this, selectedImage.getPath(), selectedImage.getName());
                Bitmap selectedImageTobeshown = BitmapFactory.decodeFile(ImageDecode);

                selectedImageTobeshown = getResizedBitmap(selectedImageTobeshown, 400);// 400 is for example, replace with desired size
                try {
                    userImageView.setImageBitmap(modifyOrientation(selectedImageTobeshown, ImageDecode));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            Toast.makeText(this, "Please try again", Toast.LENGTH_LONG)
                    .show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_EXTERNAL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length <= 0
                        || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    showMessageDialog("Cannot Open gallery because you deny the permission");
                } else {
                    openGallery();
                }
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


    public void openGallery() {
        ImagePicker.create(this)
                .returnMode(ReturnMode.ALL) // set whether pick and / or camera action should return immediate result or not.
                .folderMode(true) // folder mode (false by default)
                .toolbarFolderTitle("Folder") // folder selection title
                .toolbarImageTitle("Tap to select") // image selection title
                .single() // single mode
                .limit(1) // max images can be selected (99 by default)
                .showCamera(true) // show camera or not (true by default)
                .imageDirectory("Camera") // directory name for captured image  ("Camera" folder by default)
                //.origin(images) // original selected images, used in multi mode
                .start(IMG_RESULT); // start image picker activity with request code
    }
}